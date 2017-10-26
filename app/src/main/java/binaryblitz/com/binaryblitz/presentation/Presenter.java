package binaryblitz.com.binaryblitz.presentation;

/**
 * Created by ikakus on 9/21/17.
 */

public interface Presenter<V>{
    void onViewAttached(V view);
    void onViewDetached();
    void onDestroyed();
}
