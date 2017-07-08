public class Restaurant{
    public final int id;
    public final String name;
    public final String url;
    public final List<Integer> designRatings;
    public final List<Integer> tasteRatings;

    public Restaurant(int id, String name, String url, List<Integer> designRatings, List<Integer> tasteRatings){
        this.id = id;
        this.name = name;
        this.url = url;
        this.designRatings = designRatings;
        this.tasteRatings = tasteRatings;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getURL(){
        return url;
    }

    public List<Integer> getDesignRatings(){
        return designRatings;
    }

    public List<Integer> getTasteRatings(){
        return tasteRatings;
    }
}