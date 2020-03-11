package homework4;

/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scarb
 */
public class Rectangle {

    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;

        /*Return false if obj is null or if the 
          class of the current object != class of the input object.
         */
        if (obj != null && getClass() == obj.getClass()) {
            if (this == obj) { // if current object has same addres of input object.
                flag = true;   //  then flag is set to true
            } else {   // otherwise, compare contents of the instance variables
                Rectangle other = (Rectangle) obj;
                flag = width == other.width && length == other.length;
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "(Width, Length): (" + width + "," + length + ")";
    }

}
