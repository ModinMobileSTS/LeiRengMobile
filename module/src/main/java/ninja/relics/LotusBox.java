package ninja.relics;

import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class LotusBox extends CustomRelic {
    public static final String ID = "LotusBox";
    private static final String IMG = "img/relics_Ninja/LotusBox.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/LotusBox.png";

    //调用父类的构造方法，传参为super(遗物ID,遗物全图，遗物白底图，遗物稀有度，获得遗物时的音效)
    public LotusBox() {
        super(ID, AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG)), AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG_OTL)), RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public void atBattleStart() {
        //在战斗开始时触发
        CardCrawlGame.sound.play(ID);
        this.flash();
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new LexKela(AbstractDungeon.player, 2), 2));
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));

    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + 2 + this.DESCRIPTIONS[1];
    }

    @Override
    public AbstractRelic makeCopy() {
        return (AbstractRelic)new LotusBox();
    }
}