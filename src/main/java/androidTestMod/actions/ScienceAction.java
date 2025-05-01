package androidTestMod.actions;

import androidTestMod.powers.LexKela;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ScienceAction extends AbstractGameAction {
    private final AbstractPlayer p;
    AbstractGameAction abstractAction;

    public ScienceAction(AbstractPlayer p) {
        this.p = p;
    }

    @Override
    public void update() {
        //判断是否有蕾克拉
        AbstractPower lexKela = p.getPower("LexKela");
        if(lexKela != null &&  lexKela.amount > 0 ) {
            this.addToBot(new ApplyPowerAction(p,p,new LexKela(p,-1)));
            this.isDone = true;
        }
        else {
            this.isDone = true;
        }

    }
}
