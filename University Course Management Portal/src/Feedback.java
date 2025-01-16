public class Feedback<T> {
    private T feedbackContent;

    public Feedback(T feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public T getFeedbackContent() {
        return feedbackContent;
    }

    public String toString() {
        return feedbackContent.toString();
    }
}
