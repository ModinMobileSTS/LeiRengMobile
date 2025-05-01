package ninja.actions;

import ninja.powers.LexKela;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;

public class ShenWeiAction extends AbstractGameAction {
    
    public void update(){
        AbstractPower lexKela = AbstractDungeon.player.getPower("LexKela");
        if (lexKela != null && lexKela.amount >= 1) {
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new LexKela(AbstractDungeon.player,-1),-1));
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new IntangiblePlayerPower(AbstractDungeon.player,1),1));
            this.addToBot(new PlaySoundAction("ShenWei"));

        }
        this.isDone = true;
    }
    
}
