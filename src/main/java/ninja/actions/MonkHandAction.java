package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class MonkHandAction extends AbstractGameAction {

    private AbstractMonster m;
    private AbstractPlayer p;
    private DamageInfo info;
    public MonkHandAction (AbstractPlayer p,AbstractMonster m, DamageInfo info){
        this.p = p;
        this.m = m;
        this.info = info;
    }

    public void update(){
        this.addToBot(new DamageAction(m, this.info, AttackEffect.BLUNT_HEAVY));
        this.isDone=true;
    }

}
