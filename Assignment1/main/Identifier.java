package main;

public class Identifier
    implements IdentifierInterface
{

    public Identifier()
    {
        karakterArray = new StringBuffer();
    }

    public Identifier(Identifier teKopierenIdentifier)
    {
        karakterArray = new StringBuffer(teKopierenIdentifier.karakterArray);
    }

    public void init(char c)
    {
        karakterArray = new StringBuffer();
        voegToe(c);
    }

    public void voegToe(char c)
    {
        karakterArray.append(c);
    }

    public int lengte()
    {
        return karakterArray.length();
    }

    public boolean equals(Identifier ingevoerdeIdentifier)
    {
        return karakterArray.toString().equals(ingevoerdeIdentifier.karakterArray.toString());
    }

    public char get(int i)
    {
        return karakterArray.charAt(i);
    }

    StringBuffer karakterArray;
}
