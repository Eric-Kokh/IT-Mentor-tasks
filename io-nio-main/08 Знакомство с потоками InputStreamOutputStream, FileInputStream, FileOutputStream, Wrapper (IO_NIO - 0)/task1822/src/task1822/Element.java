package task1822;

public class Element {
    public int id;
    public String productName;
    public double price;
    public int quantity;

    @Override
    public String toString() {
        return id + " " + productName + " " + price + " " + quantity;
    }

    public Element getElementFromString(String s) {
        int i = 0;
        String[] sArray;
        sArray = s.split("\\s+");
        id = Integer.parseInt(sArray[i]);
        i++;
        productName = sArray[i];
        i++;
        for (int j = 0; j < sArray.length - 4; j++) {
            productName = productName + " " + sArray[i];
            i++;
        }
        price = Double.parseDouble(sArray[i]); i++;
        quantity = Integer.parseInt(sArray[i]);
        return this;
    }
}
