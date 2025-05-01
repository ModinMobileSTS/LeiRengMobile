package ninja.relics;

import ninja.Ninja;
import ninja.powers.PeaShooter;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import ninja.Ninja;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class SpyPeaShooter extends CustomRelic {
    public static final String ID = "SpyPeaShooter";
    private static final String IMG = "img/relics_Ninja/SpyPeaShooter.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/SpyPeaShooter.png";
    private static final int AMOUNT = 3;

    public SpyPeaShooter() {
        super(ID, AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG)), AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG_OTL)), RelicTier.COMMON, LandingSound.CLINK);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + 3 + this.DESCRIPTIONS[1];
    }

    public void atBattleStart() {
                this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new PeaShooter(AbstractDungeon.player,3)));
    }

    public AbstractRelic makeCopy() {
        return new SpyPeaShooter();
    }
}
