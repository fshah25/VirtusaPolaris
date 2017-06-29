import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

interface WithExponents
{
	// Exponents function
	public double pow(double base, double power);
	public double multiplyExp(double[] array1, double[] array2);
	public double divideExpo(double[] array1, double[] array2);
}

// Calculator Class
public class Calculator implements WithExponents
{
	// Constructor
	public Calculator()
	{
		
	}
	
	// Add function
	public static double add(double value1, double value2)
	{
		return (value1 + value2);
	}
	
	// Add function
	public static double subtract(double value1, double value2)
	{
		return (value1 - value2);
	}
	
	// Add function
	public static double multiply(double value1, double value2)
	{
		return (value1 * value2);
	}
	
	// Add function
	public static double divide(double value1, double value2)
	{
		if(value2 == 0)
			return Double.NaN;
		else
			return (value1 / value2);
	}

	public double pow(double base, double power) 
	{
		return Math.pow(base, power);
	}

	public double multiplyExp(double[] array1, double[] array2) 
	{
		double value1 = pow(array1[0], array1[1]);
		double value2 = pow(array2[0], array2[1]);
		
		return multiply(value1, value2);
	}

	public double divideExpo(double[] array1, double[] array2) 
	{
		double value1 = pow(array1[0], array1[1]);
		double value2 = pow(array2[0], array2[1]);
		
		return divide(value1, value2);
	}
	
	public static double delay(int milliseconds, Calculator calc, String function, double[] values) throws Exception
	{
		double result = Double.NaN;
		Method[] methods = calc.getClass().getMethods();
		for (Method oneMethod : methods) 
		{
			if (oneMethod.getName().equals(function)) 
			{
				try 
				{
					TimeUnit.MILLISECONDS.sleep(milliseconds);
				    result = new Double(oneMethod.invoke(calc, values).toString()).doubleValue();
				    
				} catch (Exception ex) 
				{ 
					System.out.println("Cannot execute functions that do not exist");
					throw ex;
				}
			}
		}
		
		return result;
	}
}
