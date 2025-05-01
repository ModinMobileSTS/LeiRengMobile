package androidTestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class ManTooWeakAction extends AbstractGameAction {

    private AbstractPlayer p;

    public ManTooWeakAction(){
        this.p = AbstractDungeon.player;
    }

    public void update(){
        this.addToTop(new ApplyPowerAction(p,p,new StrengthPower(p,1),1));
        this.addToTop(new ApplyPowerAction(p,p,new DexterityPower(p,1),1));
        this.isDone=true;
    }
}
