package frc.robot.Utils.Math;


public class Vector3d {
	public double m_x, m_y, m_z;
	     
	/**
	 * Created Vector 3D constructor 
	 * @param m_x is the m_x component of vector
	 * @param m_y is the m_y component of vector 
	 * @param m_z is the m_z component of vector
	 */
	
	public Vector3d(double x, double y, double z) {
	this.m_x = x;
	this.m_y = y;
	this.m_z = z;
		
	}
	/**
	 * Copied constructor of Vector 3D known as Vector3D v which will be used in doubleDot class 
	 * @param v
	 */
	public Vector3d(Vector3d v) {
		this.m_x = v.m_x;
		this.m_y = v.m_y;
		this.m_z = v.m_z;
	} 
	public Vector3d() {
		this(0, 0, 0);
	}
	/**
	 * 
	 * @return the m_x component of vector
	 */
	public double getX() {
		return m_x;
	}
	/*
	*Sets the m_x component of the vector
	*/
	public void setX(double m_x) {
		this.m_x = m_x;
	}
	/*
	 * @return the m_y component of vector
	 */
	public double getY() {
		return m_y;
	}
	/*
	 * Sets the m_y component of the vector
	 */
	public void setY (double m_y) {
		this.m_y = m_y;
	}
	/*
	 * return the m_z component of vector
	 */
    public double getZ() {
	    return m_z;
    }
    /*
     * Set the m_z component of vector
     */
    public void setZ(double m_z) {
    	this.m_z =m_z;
    }
    /*
     * Returns a string representation of vector [m_x,m_y,m_z], where m_x,m_y,m_z are the components
     */
    public String toString() {
    	return String.format("[%2f,%2f,%2f]",m_x,m_y,m_z);
    }
    /**
     * Return the magnitude of the vector
     * @return the magnitude of the vector
     */
    public double magnitude() {
    	double mag = Math.pow(this.m_x,2)+ Math.pow(this.m_y,2)+Math.pow(this.m_z,2);
    	return(Math.sqrt(mag));
    }
    /**
     * Multiplies this vector by a scalar 
     * @param f is the scalar that is multiplied 
     * @return this vector after multiplied 
     */
    public String multipleByScale(double f) {
    	double a1,a2,a3;
    	a1=this.m_x*= f;
    	a2=this.m_y*= f;
    	a3=this.m_z*= f;
    	return("(" +String.format("%2f",a1)+","+String.format("%2f",a2)+","+String.format("%2f",a3)+")");
    } 
    /**
     * Add a vector to this vector 
     * @param v taken from constructor v 
     * @return the string displaying changes the components of this vector
     */
    
	public String add(Vector3d v){
		        
		double b1,b2,b3;
		b1= this.m_x += v.m_x;
		b2 = this.m_y += v.m_y;
		b3 = this.m_z += v.m_z;
		return ("("+String.format("%2f",b1) + "," + String.format("%2f",b2) + "," + String.format("%2f",b3)+ ")");
	}
	/**
	 * Subtract a vector from this vector
	 * @param v taken from constructor v
	 * @return the string displaying changes the components of this vector
	 */
	public Vector3d subtract(Vector3d v) {
		this.m_x -= v.m_x;
		this.m_y -= v.m_y;
		this.m_z -= v.m_z;
		return this;
	}
    
	/**
	 * 
	 * @param f taken in from multiple of Scale class 
	 * @return
	 */
	public String negateVector3D(double f) {
		double d1,d2,d3;
		d1 = this.m_x *= f-1;
		d2 = this.m_y *= f-1;
		d3 = this.m_z *= f-1;
		return("(" + String.format("%2f",d1) + "," + String.format("%2f",d2) + "," + String.format("%2f",d3) + ")");
	}/**
	*Computes the dot product of the vector and the given vector
	*Dot Product equation = x1 * x2 + y1 * y2 + z1 * z2
	*@param takes in Vector3D v constructor
	*@return the Dot product of this and other vector 
	*/
	public double doubleDot(Vector3d v) {
		return m_x * v.m_x + m_y * v.m_y + m_z *v.m_z;
	}
	/*
	 * 
	 */
	public boolean equalsTo(Vector3d v , double b) {
		return Math.abs(magnitude() - v.magnitude()) < b;
	}

    public double getPitch() {
        // Calculate the magnitude of the vector
        double magnitude = Math.sqrt(m_x * m_x + m_y * m_y + m_z * m_z);

        // Ensure the vector has a non-zero magnitude
        if (magnitude == 0) {
            throw new IllegalArgumentException("Vector has zero magnitude");
        }

        // Calculate the pitch angle
        double pitch = Math.asin(m_z / magnitude);

        return pitch;
    }
}
