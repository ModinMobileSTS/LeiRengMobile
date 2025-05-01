package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class PoisonFlameAction extends AbstractGameAction {

    private AbstractPlayer p;
    private int magicNumber;

    public PoisonFlameAction(AbstractPlayer p,int magicNumber){
        this.p=p;
        this.magicNumber=magicNumber;
    }

    public void update(){
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {

            for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
                if (!monster.isDead && !monster.isDying) {
                    this.addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, this.magicNumber), this.magicNumber));
                }
            }
        }
        this.isDone=true;
    }
}
