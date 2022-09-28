public class Planet{
    public double xxPos;
    public double yyPos;
    public  double xxVel;
    public  double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        this.imgFileName = p.imgFileName;
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
    }

    public double calcDistance(Planet p){
        /** samh.calcDistance(rocinante)  */
        double x_dif = this.xxPos - p.xxPos;
        double y_dif = this.yyPos - p.yyPos;
        double dist = Math.sqrt(x_dif * x_dif + y_dif * y_dif);
        return dist;
    }
    public double calcForceExertedBy(Planet p){
        double dist = this.calcDistance(p);
        double Force = (G * this.mass * p.mass) / (dist * dist);
        return Force;
    }

    public double calcForceExertedByX(Planet p){
        double Force = this.calcForceExertedBy(p);
        double dis_x = p.xxPos - this.xxPos;
        double dis = this.calcDistance(p);
        double F_x = Force * dis_x / dis;
        return F_x;
    }

    public double calcForceExertedByY(Planet p){
        double Force = this.calcForceExertedBy(p);
        double dis_y = p.yyPos - this.yyPos;
        double dis = this.calcDistance(p);
        double F_y = Force * dis_y / dis;
        return F_y;
    }

    public double calcNetForceExertedByX(Planet[] p){
        double sum_x = 0.0;
        for (int i = 0; i < p.length; i++)
        {
            if (this.equals(p[i]))
            {
                continue;
            }
            sum_x = sum_x + this.calcForceExertedByX(p[i]);
        }
        return sum_x;
    }

    public double calcNetForceExertedByY(Planet[] p){
        double sum_y = 0.0;
        for (int i = 0; i < p.length; i++)
        {
            if (this.equals(p[i]))
            {
                continue;
            }
            sum_y = sum_y + this.calcForceExertedByY(p[i]);
        }
        return sum_y;
    }

    public void update(double dt, double fX, double fY){
        double a_x = fX / this.mass;
        double a_y = fY / this.mass;

        this.xxVel = this.xxVel + a_x * dt;
        this.yyVel = this.yyVel + a_y * dt;

        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

























}