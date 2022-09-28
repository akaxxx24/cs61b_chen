import java.io.File;

public class NBody {

    public static double readRadius(String path){
        In in = new In(path);
        int num = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        Planet[] p = new Planet[num];
        double R = in.readDouble();

/*        while(!in.isEmpty())
        {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mas = in.readDouble();
            String imFileName = in.readString();
            p[i] = new Planet(xPos,yPos,xVel,yVel,mas,imFileName);
            i++;
        }*/

        for (int i = 0; i < num; i++)
        {
            double xpos = in.readDouble();
            double ypos = in.readDouble();
            double xvel = in.readDouble();
            double yvel = in.readDouble();
            double mass = in.readDouble();
            String imgn = in.readString();
            p[i] = new Planet(xpos, ypos, xvel, yvel, mass, imgn);
        }

        return p;
    }

    public static void main(String[] args){

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = NBody.readRadius(filename);
        Planet[] p = NBody.readPlanets(filename);
        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);

        StdDraw.enableDoubleBuffering();

        for (double t = 0; t <= T; t = t + dt)
        {
            double[] xForces = new double[p.length];
            double[] yForces = new double[p.length];
            for (int i = 0; i < p.length; i++)
            {
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }
            for (int i = 0; i < p.length; i++)
            {
                p[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : p)
            {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

        }
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}