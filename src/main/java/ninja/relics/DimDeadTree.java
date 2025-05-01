package ninja.relics;

import com.megacrit.cardcrawl.helpers.ImageMaster;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import ninja.actions.PlaySoundAction;
import ninja.powers.DimDeadTreePower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class DimDeadTree extends CustomRelic {
    public static final String ID = "DimDeadTree";
    private static final String IMG = "img/relics_Ninja/DimDeadTree.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/DimDeadTree.png";
    private boolean activated = true;

    //调用父类的构造方法，传参为super(遗物ID,遗物全图，遗物白底图，遗物稀有度，获得遗物时的音效)
    public DimDeadTree() {
        super(ID, AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG)), AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG_OTL)), RelicTier.RARE, LandingSound.HEAVY);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public void atTurnStart() {

        if(!AbstractDungeon.player.hasPower("DimDeadTreePower")){
            this.addToTop(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new DimDeadTreePower(AbstractDungeon.player)));
            this.flash();
            this.addToTop(new PlaySoundAction("DimDeadTree"));
        }
    }

    public boolean checkTrigger() {
        return this.activated;
    }

    public AbstractRelic makeCopy(){
        return new DimDeadTree();
    }
}
