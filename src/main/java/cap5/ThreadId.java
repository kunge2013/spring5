package cap5;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId
{
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal threadId = new ThreadLocal();
}