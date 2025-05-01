package ninja.actions;

import ninja.powers.RadiationAnnihilationPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;

public class RadiationAnnihilationAction extends AbstractGameAction {
    private AbstractPlayer p;
    private int magicNumber;
    public RadiationAnnihilationAction(AbstractPlayer p,int magicNumber){
        this.p=p;
        this.magicNumber=magicNumber;
    }

    public void update(){
        for(AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            this.addToBot(new VFXAction(new SmokeBombEffect(mo.hb.cX, mo.hb.cY)));
            this.addToBot(new ApplyPowerAction(mo, p, new RadiationAnnihilationPower(mo, this.magicNumber), this.magicNumber, true, AttackEffect.FIRE));
        }

        this.isDone=true;
    }

}
