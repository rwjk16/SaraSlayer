package tasks

public abstract class BaseTask(
    private var name: String = "Un-named"
) {

    public abstract fun shouldExcecute(): Boolean
    public abstract fun run()
}