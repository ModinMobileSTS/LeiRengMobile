package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import ninja.powers.DimDeadTreePower;
import ninja.powers.LexKela;
import ninja.relics.MachineNinja;

public class NinjutsuActionBot extends AbstractGameAction {
    private final AbstractPlayer p;
    private int ninjutsuKela;
    AbstractGameAction abstractAction;
    private String key;

    public NinjutsuActionBot(AbstractPlayer p, AbstractGameAction abstractAction, int ninjutsuKela, String key) {
        this.actionType = ActionType.REDUCE_POWER;
        this.source = p;
        this.p = p;
        this.ninjutsuKela = ninjutsuKela;
        this.abstractAction = abstractAction;
        this.key = key;
    }

    public void update() {
        AbstractPower lexKela = this.p.getPower(LexKela.POWER_ID);
        AbstractPower dimdeadtree = this.p.getPower(DimDeadTreePower.POWER_ID);
        if (dimdeadtree != null) {
            CardCrawlGame.sound.play(this.key);
            addToBot(this.abstractAction);
            this.isDone = true;
            return;
        }
        if (this.p.hasRelic(MachineNinja.ID)) {
            this.ninjutsuKela++;
        }
        if (lexKela != null && lexKela.amount >= this.ninjutsuKela) {
            CardCrawlGame.sound.play(this.key);
            addToBot(this.abstractAction);
            addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new LexKela(AbstractDungeon.player, -this.ninjutsuKela)));
            this.isDone = true;
            return;
        }
        this.isDone = true;
    }
}
