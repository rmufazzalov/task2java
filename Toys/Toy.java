package drawingOfToys.Toys;

public abstract class Toy {
    private int id;
    private String title;
    private int quantity;
    private int chance;

    public Toy(int id, String title, int quantity, int chance) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.chance = chance;

    }

    public int getChance() {
        return chance;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAllInfo() {
        return "Имя: " + this.getTitle() + " |Количество: " + this.getQuantity() + " |Шанс выпадения: "
                + this.getChance();
    }

    public void setQuantity(int quantity) {
        if (0 <= quantity) {
            this.quantity = quantity;
        } else {
            System.out.println("Неправильное количество");
            return;
        }
    }

    public void downQuantity() {
        if (this.quantity == 0) {
            System.out.println(this.title + " больше нет");
            return;
        } else {
            this.quantity = this.quantity - 1;
        }

    }

    public void setChance(int chance) {
        if (0 <= chance && chance <= 100) {
            this.chance = chance;
        } else {
            System.out.println("Неправильный вес, установлено минимальное значение");
            this.chance = 20;
        }

    }
}
