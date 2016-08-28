package chapter7.concurrency.issues;

/**
 * LiveLock is a special case of DeadLock and Starvation. It happens when to threads
 * swap locked resources. eg:
 * 
 *  T1 - Thread 1
 *  T2 - Thread 2
 *  R1 - Locked resource 1
 *  R2 - Locked resource 2
 *  
 *  T1 waits R1
 *  T2 waits R1
 *  
 *  --- swap ---
 *  
 *  T1 waits R2
 *  T2 waits R2
 *  
 *  --- swap ---
 *  
 *  T1 waits R1
 *  T2 waits R1
 *  
 *  and so on...
 *  
 *  LiveLocks is also known as a failed deadlock recovery
 * 
 * @author root
 *
 */
public class LiveLock {

}
