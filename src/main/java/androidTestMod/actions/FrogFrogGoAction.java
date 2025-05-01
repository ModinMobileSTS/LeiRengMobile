package androidTestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;

public class FrogFrogGoAction extends AbstractGameAction {

    private int magicNumber;

    public FrogFrogGoAction(int magicNumber){
        this.magicNumber = magicNumber;
    }

    public void update(){
        this.addToBot(new ExhaustAction(1,false));
        this.addToBot(new GainEnergyAction(this.magicNumber));
        this.isDone=true;
    }

}
