package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.EntanglePower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;

public class WePeaceAction extends AbstractGameAction {

    private int magicNumber;

    public WePeaceAction(int magicNumber){
        this.magicNumber = magicNumber;
    }

    public void update(){
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new EntanglePower(AbstractDungeon.player)));
        if(!AbstractDungeon.player.hasPower("IntangiblePlayer")) {
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new IntangiblePlayerPower(AbstractDungeon.player, this.magicNumber), this.magicNumber));
        }
        this.isDone=true;
    }

}
