public class Player {
    private float rating;
    private String name;
    private String fileName;

    public Player(String name, String fileName) {
        this.name = name;
        rating = 1000; //default rating
        this.fileName = fileName;
    }

    public Player(String name, float rating, String fileName) {
        this.name = name;
        this.rating = rating;
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getFileName() {
        return fileName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
