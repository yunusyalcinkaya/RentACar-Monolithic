package kodlama.io.rentACars.entities.concretes;

public class Brand { //marka
    private int id;
    private String name;// isimlendirmeleri brandname, brandId gibi yapma!!!

    public Brand() {// no args contructor
    }

    public Brand(int id, String name) { // all args contructor
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
