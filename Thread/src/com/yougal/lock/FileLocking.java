package com.yougal.lock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

// The class demonstrates how to get an exclusive file lock that prevents other threads and processes / JVMs from
// obtaining a lock on the same file. To do this, you need to synchronize a block on a file and acquire FileLock. See
// comments below for more details. Run this class in multiple JVMs and see each thread of each JVM acquires a lock in
// an orderly fasion.
public class FileLocking extends Thread
{
    private static final File file = new File("lock.test");
    
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 5; i++) {
            new FileLocking().start();
        }
    }

    @Override
    public void run()
    {
        // synchronized on a static variable "file" so that threads don't try to acquire a lock on it at the same
        // time. Javadoc of FileLock states "File locks are held on behalf of the entire Java virtual machine. They are
        // not suitable for controlling access to a file by multiple threads within the same virtual machine." What this
        // actually means is that if two threads tries to get a lock on the same file, one fails with
        // OverlappingFileLockException instead of waiting for a release of the lock.
        synchronized(file) {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);

                // Synchronization doesn't have any effect on threads running on a different JVM, of
                // course. FileChannel.lock() acquires a lock on a file that prevents another process from getting a
                // lock on it. The method waits until a lock is released if the lock is held by a different process, as
                // opposed to throwing exception when the lock is held by a thread in the same JVM.
                FileLock lock = fos.getChannel().lock();
                System.out.println("Got a lock in " + getName());

                // do some file write operation

                sleep(1000);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
    }
            
}
