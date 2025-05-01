package ninja.actions;

import ninja.powers.LexKela;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class NinjutsuAction extends AbstractGameAction {

    private final AbstractPlayer p;
    private int ninjutsuKela;
    AbstractGameAction abstractAction;
    private String key;

    public NinjutsuAction(AbstractPlayer p, AbstractGameAction abstractAction , int ninjutsuKela, String key) {
        this.actionType = ActionType.REDUCE_POWER;
        this.source = p;
        this.p = p;
        this.ninjutsuKela = ninjutsuKela;
        this.abstractAction = abstractAction;
        this.key = key;
    }

    @Override
    public void update() {
        //判断蕾克拉是否足够
        AbstractPower lexKela = p.getPower("LexKela");
        AbstractPower dimdeadtree = p.getPower("DimDeadTreePower");
        if(dimdeadtree != null){
            //暗寒死树生效则不消耗蕾克拉
                        this.addToBot(abstractAction);
            this.isDone = true;
        }
        else {
            //暗寒死树不生效则判断蕾克拉是否足够
            if(p.hasRelic("MachineNinja")){
                ninjutsuKela++;
            }

            if (lexKela != null && lexKela.amount >= ninjutsuKela) {
                //释放忍术
                                this.addToBot(abstractAction);
                this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new LexKela(AbstractDungeon.player, -this.ninjutsuKela)));

                this.isDone = true;
            } else {
                //不够就无事发生
                this.isDone = true;
            }
        }
    }
}
