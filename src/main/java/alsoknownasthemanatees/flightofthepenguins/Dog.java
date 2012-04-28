
package alsoknownasthemanatees.flightofthepenguins;

import alsoknownasthemanatees.flightofthepenguins.graphics.Entity;



public class Dog extends Entity {
    
    public static final double SNIFF_DISTANCE = 200;
    
    public Dog (double x, double y, Level level) {
        super(Type.DOG, x, y, level);
    }
    
    @Override
    public void update (double dt) {
        super.update(dt);
        Entity p = level.player;
        double xDistance = p.x - this.x;
        double yDistance = p.y - this.y;
        if ((xDistance * xDistance + yDistance * yDistance) < SNIFF_DISTANCE * SNIFF_DISTANCE)
        {
            double total = Math.abs(xDistance) + Math.abs(yDistance);
            //double angle = Math.atan(yDistance/xDistance);
            x += (xDistance / total) * dt * 40;
            y += (yDistance / total) * dt * 40;
        }
        
    }
    
                
}
