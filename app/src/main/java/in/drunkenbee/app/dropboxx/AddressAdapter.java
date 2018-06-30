package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 10/6/18.
 */

public class AddressAdapter {

    private int addressId;
    private int pinCode;
    private int addressType;
    private String address;

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getPinCode() {
        return pinCode;
    }
}
