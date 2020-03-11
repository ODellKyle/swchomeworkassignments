/* Kyle O'Dell
 * Dr. Carl Scarbnick
 * Math 140
 * November 16, 2018
 * Homework 4 - further develop LinkedList data structure
 * to become much more versatile.
 */

package homework4;

// Test class for HW4

public class Test {
    public static void main(String[] args) {
        LinkedList<Rectangle> listOne = new LinkedList<>();
        Rectangle[] rectArr = {new Rectangle(1, 15), new Rectangle(1, 4),
            new Rectangle(100, 8), new Rectangle(15, 340),
            new Rectangle(72, 4), new Rectangle(150, 55),
            new Rectangle(2020, 1008), new Rectangle(700, 34023),
            new Rectangle(72, 818), new Rectangle(93, 890), null,
            new Rectangle(72, 13), new Rectangle(97, 6),
            new Rectangle(1, 34023), new Rectangle(93, 6),
            new Rectangle(72, 818), new Rectangle(93, 55), null,
            new Rectangle(72, 13), new Rectangle(97, 677),
            new Rectangle(8, 9), new Rectangle(9, 8),
            new Rectangle(36, 2), new Rectangle(400, 2),
            new Rectangle(72, 1008), new Rectangle(93, 340)
        };

        for (Rectangle r : rectArr) {
            listOne.add(r);
        }
        LinkedList<Rectangle> listTwo = new LinkedList<>();
        System.out.println("addAll: " + listTwo.addAll(listOne));
        listTwo.add(new Rectangle(93, 340));
        listTwo.add(null);
        
        System.out.println("\n contents of listTwo: ");
        for (Rectangle r : listTwo) {
            System.out.println(r);
        }
        
        System.out.println("\nRemove Rectangle objects from listOne: ");
        System.out.println(listOne.remove(null));
        System.out.println(listOne.remove(new Rectangle(1, 15)));
        System.out.println(listOne.remove(new Rectangle(10, 15)));
        
        
        System.out.println("\nRemove All Method 1: ");
        System.out.println(listTwo.removeAll(listOne));
        System.out.println("\nContents of listTwo:" );
        for (Rectangle r : listTwo) {
            System.out.println(r);
        }
        listOne = new LinkedList<>();
        System.out.println("\nRemove All Method 2: ");
        System.out.println(listTwo.removeAll(listOne));
        
        listOne.add(new Rectangle(100, 100));
        listOne.add(new Rectangle(100, 600));
        System.out.println("\nRemove All Method 3: ");
        System.out.println(listTwo.removeAll(listOne));
        
        System.out.println("\nContains All Method 1: ");
        System.out.println(listTwo.containsAll(listOne));
        System.out.println("\nContains All Method 2: ");
        listTwo.add(new Rectangle(100, 100));
        listTwo.add(new Rectangle(100, 600));
        System.out.println(listTwo.containsAll(listOne));
        listOne = null;
        System.out.println("\nContains All Method 3: ");
        System.out.println(listTwo.containsAll(listOne));
        
        listOne = new LinkedList<>();
        for (Rectangle r : rectArr) {
            listOne.add(r);
        }
        
        System.out.println("\n Test the filter method: Width greater than 10 ");
        /* Step 1:
           Enter a lambda expression that represents a Predicate object. 
            The Predicate is true when 
             (1) A Rectangle object isn't null and 
             (2) The width of the Rectangle is greater than 10
        */
        listTwo = listOne.filter(r -> r != null && r.getWidth() > 10);  // enter a lambda expression as an argument
        for (Rectangle r : listTwo) {
            System.out.println(r);
        }
        
        System.out.println("\n Test the filter method: length greater than width ");
        /* Step 2:
           Enter a lambda expression that represents a Predicate object. 
            The Predicate is true when 
             (1) A Rectangle object isn't null and 
             (2) The length of the Rectangle is greater  than the width
        */
        listTwo = listOne.filter(r -> r != null && r.getLength() > r.getWidth()); // enter a lambda expression as an argument
        for (Rectangle r : listTwo) {
            System.out.println(r);
        }
        
        System.out.println("\n Test the greater than method: Areas greater than area " 
                          + "of a rectangle with width = 100 and length = 2");
        /* Step :3
           Enter a lambda expression that represents a Comparator object.
             The Comparator orders Rectangle objects is ascending order by area.
        */
        
        listTwo = listOne.greaterThan(new Rectangle(100, 2), (r1, r2) -> r1.getLength() * r1.getWidth() - r2.getLength() * r2.getWidth()); // enter a lambda expression as an argument
        for (Rectangle r : listTwo) {
            System.out.println(r);
        }
        
        System.out.println("\n Test the less than method: All rectangles with length less than "
                          + " a rectangle with length = 400");
        /* Step :4
           Enter a lambda expression that represents a Comparator object.
             The Comparator orders Rectangle objects is ascending order by length.
        */
        
        listTwo = listOne.lessThan(new Rectangle(1, 400), (r1, r2) -> r1.getLength() - r2.getLength()); // enter a lambda expression as an argument
        for (Rectangle r : listTwo) {
            System.out.println(r);
        }
    }
}
