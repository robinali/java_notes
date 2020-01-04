class ZeroEvenOdd {
    private int n;
    private boolean iszero=true;
    private boolean isodd=true;
    private boolean iseven=false;

    private Object lock = new Object();
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
           synchronized (lock) {
            while(!iszero){
                lock.wait();
            }
            printNumber.accept(0);
            iszero=false;
            lock.notifyAll();
        }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
        synchronized (lock) {
            while(iszero || !iseven){
                lock.wait();
            }
            printNumber.accept(i);
            iseven=false;
            isodd=true;
            iszero=true;
            lock.notifyAll();
        }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
        synchronized (lock) {
            while(iszero || !isodd){
                lock.wait();
            }
            printNumber.accept(i);
            iseven=true;
            isodd=false;
            iszero=true;
            lock.notifyAll();
        }
        }
    }
}