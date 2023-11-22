import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class AsyncMemoizingImageLoader {
    private final ConcurrentMap<Integer, Future<Bitmap>> bitmaps = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(8);

    // TODO: shutdown executor when complete

    public Future<Bitmap> getPicture(final int pictureID) {
        if (!bitmaps.contains(pictureID)) {
            RunnableFuture<Bitmap> future = new FutureTask<Bitmap>(new Callable<Bitmap>() {
                @Override public Bitmap call() throws Exception {
                    // HTTP stuff goes here.  pictureID is accessible in this scope
                }
            });

            // This bit is key; only submit the future for completion if the
            // picture id isn't already being processed
            if (bitmaps.putIfAbsent(pictureID, future) == null) {
                executor.submit(future);
            }
        }

        return bitmaps.get(pictureID);
    }
}