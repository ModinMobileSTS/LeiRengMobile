package androidTestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.BlizzardEffect;

public class WaterSandAction extends AbstractGameAction {
    private AbstractPlayer p;
    private int blockNumber;

    public WaterSandAction(AbstractPlayer p){
        this.p = p;
    }

    @Override
    public void update(){
            int count = 0;
            AbstractPower Sand = p.getPower("SandWall");
            this.addToBot(new GainBlockAction(p,Sand.amount));
            this.addToBot(new VFXAction(new BlizzardEffect(0, AbstractDungeon.getMonsters().shouldFlipVfx()), 0.20F));
            this.addToBot(new DamageAllEnemiesAction(p, Sand.amount, DamageInfo.DamageType.NORMAL, AttackEffect.BLUNT_HEAVY));
            this.isDone=true;
        }
}
