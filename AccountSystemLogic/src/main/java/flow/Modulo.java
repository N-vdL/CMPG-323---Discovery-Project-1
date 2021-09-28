package flow;

public class Modulo
{
    public Integer doMod(int divided, int divisor) {

        if(divisor == 0)
        {
            throw new RuntimeException("There is an error present!");
            //return null;
        }

        return divided % divisor;
    }
}
