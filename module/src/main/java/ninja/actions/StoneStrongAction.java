package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.MetallicizePower;

public class StoneStrongAction extends AbstractGameAction {

    private AbstractPlayer p;
    private int magicNumber;

    public StoneStrongAction(AbstractPlayer p,int magicNumber){
        this.p = p;
        this.magicNumber = magicNumber;
    }

    public void update(){
        this.addToBot(new ApplyPowerAction(p, p, new MetallicizePower(p, this.magicNumber), this.magicNumber));
        this.addToBot(new RemoveDebuffsAction(AbstractDungeon.player));
        this.isDone=true;
    }
}
