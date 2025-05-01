package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class BeastShoutAction extends AbstractGameAction {

    private int magicNumber;

    public BeastShoutAction(int magicNumber ){
        this.magicNumber = magicNumber;
    }

    public void update(){

        for(AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
                this.addToBot(new ApplyPowerAction(mo, AbstractDungeon.player, new StrengthPower(mo, -this.magicNumber), -this.magicNumber, true, AttackEffect.NONE));
        }
        this.isDone=true;
    }

}
