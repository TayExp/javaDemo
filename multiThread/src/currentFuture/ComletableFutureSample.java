package currentFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;

class StockSupplier implements Supplier<Float> {
	
	@Override
	public Float get() {
		String url = "https://";
		System.out.println("GET: " + url);
		try {
			String result = DownloadUtil.download(url);
			String[] ss = result.split(",");
			return Float.parseFloat(ss[3]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

public class ComletableFutureSample {

	public static void main(String[] args) {
		CompletableFuture<Float> getStockFuture = CompletableFuture.supplyAsync(new StockSupplier());
		getStockFuture.thenAccept(new Consumer<Float>() {
			@Override
			public void accept(Float price){
				System.out.println("Current price "+price);
			}
		});
		getStockFuture.exceptionally(new Function<Throwable, Float>(){
			@Override
			public Float apply(Throwable t){
				System.out.println("Error: " + t.getMessage());
				return Float.NaN;
			}
		});
		getStockFuture.join();

	}

}
