
package com.verifone.isd.vsms2.sys.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class CommonThreadPoolUtil maintains a common cached thread pool executor
 * to be used across different services/applications. This class creates a thread
 * pool that creates new threads as needed, but will reuse previously
 * constructed threads when they are available. These pools will typically
 * improve the performance of programs that execute many short-lived
 * asynchronous tasks. Calls to execute will reuse previously constructed
 * threads if available. If no existing thread is available, a new thread will
 * be created and added to the pool. Threads that have not been used for sixty
 * seconds are terminated and removed from the cache. Thus, a pool that remains
 * idle for long enough will not consume any resources
 * 
 * This class is also responsible for generating Thread Names, using an incrementing counter
 * 
 * @author Raghavendra_R1
 *
 */
public class CommonThreadPoolUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonThreadPoolUtil.class);
	
	private final static CommonThreadPoolUtil INSTANCE = new CommonThreadPoolUtil();
	private final ExecutorService executor = Executors.newCachedThreadPool();
	/*
	 * Map to maintain the ScheduledFutures and ScheduledExecutorService instances, for ability to cleanup later
	 */
	private Map<ScheduledFuture<?>, ScheduledExecutorService> schedulerMap = new ConcurrentHashMap<ScheduledFuture<?>, ScheduledExecutorService>();
	private ScheduledExecutorService sweeperScheduler = Executors.newSingleThreadScheduledExecutor();
	
	private static final int SCHEDULERS_SWEEP_INTERVAL = 1;
	private static final int MAX_COUNTER_VALUE = 10000;
	private static final String HYPHEN = "-";
	private static final String LEFT_BRACKET = "[";
	private static final String RIGHT_BRACKET = "]";

	private Map<ThreadNameClient, Integer> counterMap;	//One Counter for each Thread Name Client(service, like CW, DCR, etc)
	private Map<ThreadNameClient, Semaphore> countSema4Map; //One Semaphore for each Thread Name Client(service, like CW, DCR, etc)
	
	private CommonThreadPoolUtil() {
		this.counterMap = new HashMap<ThreadNameClient, Integer>();
		this.countSema4Map = new HashMap<ThreadNameClient, Semaphore>();
		for(ThreadNameClient client : ThreadNameClient.values()) {
			this.counterMap.put(client, Integer.valueOf(0));
			this.countSema4Map.put(client, new Semaphore(1));
		}
		/*
		 * Scheduled the Sweeper, which will frequently check if any ScheduledFutures are done, 
		 * and then does a shutdown of the corresponding ScheduledExecutorServices
		 */
		sweeperScheduler.scheduleAtFixedRate(new Sweeper(), SCHEDULERS_SWEEP_INTERVAL, SCHEDULERS_SWEEP_INTERVAL, TimeUnit.MINUTES);
	}
	
	/**
	 * @return the theInstance
	 */
	public static CommonThreadPoolUtil getInstance() {
		return INSTANCE;
	}

	/**
	 * Executes the Runnable command using the Cached Thread Pool Executor
	 * 
	 * @param command
	 */
	public void execute(final Runnable command) {
		if(null != command) {
			LOGGER.debug("CommonThreadPoolUtil places a Runnable now");
			this.executor.execute(command);
		}
	}
	
	/**
	* This is a generic method, which takes a Callable command to execute
	* Executes the Callable command using the Cached Thread Pool Executor
	* Returns the Future instance
	* 
	* @param <T>
	* 
	* @param command
	* @return 
	*/
	public <T> Future<T> execute(Callable<T> command) {
		Future<T> future = null; 
		if(null != command) {
			LOGGER.debug("CommonThreadPoolUtil places a Callable now");
			future = this.executor.submit(command);
		}
		return future;
	}
	
	/**
	 * This is a generic method, which takes a Runnable command to Schedule.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * This method assumes a default TimeUnit of MILLISECONDS
	 * 
	 * @param command
	 * @param initialDelay
	 * @return
	 */
	public ScheduledFuture<?> schedule(Runnable command, long initialDelay) {
		return this.schedule(command, initialDelay, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * This is a generic method, which takes a Runnable command to Schedule.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * @param command
	 * @param initialDelay
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> schedule(Runnable command, long initialDelay, TimeUnit unit) {
                ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<?> future = scheduler.schedule(command, initialDelay, unit);
		this.schedulerMap.put(future, scheduler);
		return future;
	}
	
	/**
	 * This is a generic method, which takes a Runnable command to Schedule at a fixed rate.
	 * It takes an initialDelay, and the period/frequency as parameters.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * This method assumes a default TimeUnit of MILLISECONDS
	 * 
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period) {
		return this.scheduleAtFixedrate(command, initialDelay, period, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * This is a generic method, which takes a Runnable command to Schedule at a fixed rate.
	 * It takes an initialDelay, and the period/frequency as parameters.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> scheduleAtFixedrate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(command, initialDelay, period, unit);
		this.schedulerMap.put(future, scheduler);
		return future;
	}
	
	/**
	 * This is a generic method, which takes a Runnable command to Schedule at a fixed rate.
	 * It takes an initialDelay, and the period/frequency as parameters.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * @param threadPrefix
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @param unit
	 * @return
	 */
	public ScheduledFuture<?> scheduleAtFixedrate(String threadPrefix, Runnable command, long initialDelay, long period, TimeUnit unit) {
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new CommonThreadFactory(threadPrefix));
		ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(command, initialDelay, period, unit);
		this.schedulerMap.put(future, scheduler);
		return future;
	}
	
	/**
	 * This is a generic method, which takes a Callable command to Schedule.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * This method assumes a default TimeUnit of MILLISECONDS
	 * 
	 * @param <T>
	 * @param command
	 * @param initialDelay
	 * @return
	 */
	public <T> ScheduledFuture<T> schedule(Callable<T> command, long initialDelay) {
		return this.schedule(command, initialDelay, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * This is a generic method, which takes a Callable command to Schedule.
	 * It creates a new SingleThreadScheduledExecutor, schedules the task, 
	 * stores the ScheduledFuture and ScheduledExecutorService, 
	 * and returns the ScheduledFuture reference 
	 * 
	 * The caller is free to cancel the future at any time
	 * This class takes the responsibility of shutting down the executor after the future is done
	 * 
	 * @param <T>
	 * @param command
	 * @param initialDelay
	 * @param unit
	 * @return
	 */
	public <T> ScheduledFuture<T> schedule(Callable<T> command, long initialDelay, TimeUnit unit) {
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<T> future = scheduler.schedule(command, initialDelay, unit);
		this.schedulerMap.put(future, scheduler);
		return future;
	}

	/**
	 * Generates a Thread Name with the details as given by the Client.
	 * If (position > 0), then includes position in thread name.
	 * 
	 * The final result will be like - "client-namePrefix-14-347", for Example - "DCR-KbdDataNotifier-14-347".
	 * OR - "CW-Poller-347"(CW Poller has nothing to do with any positions).
	 * 
	 * @param client, the enum ThreadNameClient.
	 * @param threadDetails, any String which indicates what this thread is doing
	 * @param position, if this thread is doing work for any specific position.
	 * 
	 * @return threadName, a String in the format - "client-namePrefix-14-347"
	 */
	public String getThreadName(ThreadNameClient client, String threadDetails, int position) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(client.name());
		sb.append(HYPHEN);
		
		if (null != threadDetails) {
			sb.append(threadDetails);
			sb.append(HYPHEN);
		}
		
		if(position > 0) {
			sb.append(LEFT_BRACKET);
			sb.append(position);
			sb.append(RIGHT_BRACKET);
			sb.append(HYPHEN);
		}
		
		sb.append(this.getCount(client));
		
		return sb.toString();
	}

	/**
	 * Increments count for that client upto MAX_VALUE.
	 * After that the count is reset to start from 0.
	 * 
	 */
	private int getCount(ThreadNameClient client) {
		Semaphore sema4 = this.countSema4Map.get(client);
		int count = 0;
		try {
			sema4.acquireUninterruptibly();
			count = this.counterMap.get(client).intValue();
			if(count < MAX_COUNTER_VALUE) {
				count++;
			} else {
				count = 0;
			}
			this.counterMap.put(client, Integer.valueOf(count));
		} finally {
			sema4.release();
		}
		return count;
	}
	
	/**
	 * Overloaded method. Sets position as 0.
	 * 
	 * @param namePrefix
	 * @return
	 */
	public String getThreadName(ThreadNameClient client, String namePrefix) {
		return this.getThreadName(client, namePrefix, 0);
	}
	
	
	/**
	 * Every Service(like CW, DCR, FUEL, etc.) can become a Client for Thread Names.
	 * Each service will get a sequence of thread names, with count going from 0 to MAX_COUNTER_VALUE.
	 * 
	 * @author Raghavendra_R1
	 *
	 */
	public enum ThreadNameClient {
		DCR,
		FUEL,
		CW,
		TLS,
		MOBILE,
		CORE,
		POS,
		AVI,
		SYS_UPDATE,
		FDC_UPDATE,
		AUTO_UPGRADE,
		KIOSK_UPGRADE,
		RMI,
		EPS;
	}
	
	/**
	 * Sweeper thread, which frequently(default of 1 minute) iterates through all the ScheduledFutures,
	 * if any future is done(either normal completion, or exception, or canceled),
	 * shuts down the executor, and removes the future and executor from the map
	 * 
	 * This is important to ensure that there is no indefinite build of executors 
	 * that are living in the system after their tasks are completed
	 * 
	 * @author Raghavendra_R1
	 *
	 */
	private class Sweeper implements Runnable {

		@Override
		public void run() {
			Thread.currentThread().setName("Common-Thread-Pool-Sweeper");
			List<ScheduledFuture<?>> doneFutures = new ArrayList<ScheduledFuture<?>>();
			for(ScheduledFuture<?> future : schedulerMap.keySet()) {
				if(future.isDone()) {
					schedulerMap.get(future).shutdownNow(); //Shutdown the executor
					doneFutures.add(future); //add to the list of futures that we no longer need
				}
			}
			for(ScheduledFuture<?> future : doneFutures){
				schedulerMap.remove(future);//remove the entry from the map.
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		LOGGER.info("Finalize of CommonThreadPoolUtil");
		this.executor.shutdownNow();
		this.sweeperScheduler.shutdownNow();
		super.finalize();
	}
	
	public void prepareForShutdown() {
		LOGGER.info("Stop of CommonThreadPoolUtil");
		this.executor.shutdownNow();
		for(ScheduledFuture<?> future : schedulerMap.keySet()) {
			schedulerMap.get(future).shutdownNow(); //Force Shutdown any pending executors
		}
		this.sweeperScheduler.shutdownNow();
	
	}
	
	static class CommonThreadFactory implements ThreadFactory {
		private final ThreadGroup group;
		private static final AtomicInteger threadNumber = new AtomicInteger(1);
		private final String namePrefix;

		CommonThreadFactory(String namePrefix) {
			SecurityManager s = System.getSecurityManager();
			group = (s != null) ? s.getThreadGroup() : Thread.currentThread()
					.getThreadGroup();
			this.namePrefix = namePrefix + "-";
		}

		public Thread newThread(Runnable r) {
			Thread t = new Thread(group, r, namePrefix
					+ threadNumber.getAndIncrement(), 0);
			if (t.isDaemon())
				t.setDaemon(false);
			if (t.getPriority() != Thread.NORM_PRIORITY)
				t.setPriority(Thread.NORM_PRIORITY);
			return t;
		}
	}
	
}
