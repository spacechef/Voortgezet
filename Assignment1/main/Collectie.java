package main;

public class Collectie

    implements CollectieInterface
{


	static final int MAXIMALE_AANTAL_IDENTIFIERS = 20;
	static final int MINIMALE_AANTAL_IDENTIFIERS = 0;
	Identifier identifierArray[];
	
    public Collectie()
    {
        identifierArray = new Identifier[0];
    }

    public Collectie(Collectie teKopierenCollectie)
    {
        identifierArray = new Identifier[teKopierenCollectie.lengte()];
        for(int i = 0; i < lengte(); i++)
            identifierArray[i] = new Identifier(teKopierenCollectie.identifierArray[i]);

    }

    public void init()
    {
        identifierArray = new Identifier[0];
    }

    public void voegToe(Identifier invoerIdentifier)
        throws Exception
    {
        if(!bevat(invoerIdentifier))
            if(lengte() < 20)
            {
                Collectie buffer = new Collectie(this);
                identifierArray = new Identifier[lengte() + 1];
                for(int i = 0; i < buffer.lengte(); i++)
                    identifierArray[i] = new Identifier(buffer.identifierArray[i]);

                identifierArray[buffer.lengte()] = new Identifier(invoerIdentifier);
            } else
            {
                throw new Exception("Geef maximaal 20 unieke identifiers als input.");
            }
    }

    public int lengte()
    {
        return identifierArray.length;
    }

    public boolean bevat(Identifier meegegevenIdentifier)
    {
        for(int i = 0; i < lengte(); i++)
            if(identifierArray[i].equals(meegegevenIdentifier))
                return true;

        return false;
    }

    public void verwijder(Identifier teVerwijderenIdentifier)
    {
        Collectie buffer = new Collectie(this);
        identifierArray = new Identifier[lengte() - 1];
        int invoerIndex = 0;
        for(int i = 0; i < buffer.lengte(); i++)
            if(!buffer.identifierArray[i].equals(teVerwijderenIdentifier))
            {
                identifierArray[invoerIndex] = new Identifier(buffer.identifierArray[i]);
                invoerIndex++;
            }

    }

    public Identifier pak()
    {
        return identifierArray[lengte() - 1];
    }

    public Collectie vereniging(Collectie collectie2)
        throws Exception
    {
        Collectie vereniging = new Collectie();
        for(int i = 0; i < lengte(); i++)
            vereniging.voegToe(identifierArray[i]);

        for(int i = 0; i < collectie2.lengte(); i++)
            vereniging.voegToe(collectie2.identifierArray[i]);

        if(vereniging.lengte() > 20)
            throw new Exception("Geef maximaal 20 unieke identifiers als input.");
        else
            return vereniging;
    }

    public Collectie verschil(Collectie ander)
    {
        Collectie verschil = new Collectie(this);
        for(int i = 0; i < ander.lengte(); i++)
            if(verschil.bevat(ander.identifierArray[i]))
                verschil.verwijder(ander.identifierArray[i]);

        return verschil;
    }

    public Collectie symmetrischVerschil(Collectie ander)
        throws Exception
    {
        Collectie verschil1 = verschil(ander);
        Collectie verschil2 = ander.verschil(this);
        Collectie symmetrischVerschil = verschil1.vereniging(verschil2);
        if(symmetrischVerschil.lengte() > 20)
            throw new Exception("Geef maximaal 20 unieke identifiers als input.");
        else
            return symmetrischVerschil;
    }

    public Collectie intersectie(Collectie ander)
    {
        Collectie intersectie = new Collectie();
        Collectie kleinsteCollectie;
        Collectie grootsteCollectie;
        if(lengte() > ander.lengte())
        {
            kleinsteCollectie = ander;
            grootsteCollectie = this;
        } else
        {
            kleinsteCollectie = this;
            grootsteCollectie = ander;
        }
        for(int i = 0; i < kleinsteCollectie.lengte(); i++)
            if(grootsteCollectie.bevat(kleinsteCollectie.identifierArray[i]))
                try
                {
                    intersectie.voegToe(kleinsteCollectie.identifierArray[i]);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

        return intersectie;
    }
}
