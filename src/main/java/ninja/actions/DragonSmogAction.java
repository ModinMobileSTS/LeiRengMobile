package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.actions.utility.ShakeScreenAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;

public class DragonSmogAction extends AbstractGameAction {
    private  AbstractMonster m;
    private  AbstractPlayer p;
    private  int magicNumber;

    public DragonSmogAction(AbstractPlayer p, AbstractMonster m,int magicNumber){
        this.p = p;
        this.m = m;
        this. magicNumber = magicNumber;
    }

    public void update(){
        this.addToBot(new ShakeScreenAction(0.2F, ScreenShake.ShakeDur.MED, ScreenShake.ShakeIntensity.HIGH));
        for(AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            this.addToBot(new VFXAction(new SmokeBombEffect(mo.hb.cX, mo.hb.cY)));
            this.addToBot(new ApplyPowerAction(mo, p, new WeakPower(mo, this.magicNumber, false), this.magicNumber, true, AttackEffect.FIRE));
            this.addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, this.magicNumber, false), this.magicNumber, true, AttackEffect.FIRE));
        }
        this.addToBot(new RemoveDebuffsAction(AbstractDungeon.player));
        this.isDone=true;
    }
}
