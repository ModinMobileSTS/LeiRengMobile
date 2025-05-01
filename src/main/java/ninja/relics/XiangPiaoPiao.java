package ninja.relics;

import com.megacrit.cardcrawl.helpers.ImageMaster;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class XiangPiaoPiao extends CustomRelic {
    public static final String ID = "XiangPiaoPiao";
    private static final String IMG = "img/relics_Ninja/XiangPiaoPiao.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/XiangPiaoPiao.png";

    //调用父类的构造方法，传参为super(遗物ID,遗物全图，遗物白底图，遗物稀有度，获得遗物时的音效)
    public XiangPiaoPiao() {
        super(ID, AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG)), AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG_OTL)), RelicTier.BOSS, LandingSound.FLAT);
    }

    public void atTurnStart() {
        //在回合开始时触发
                this.flash();
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new LexKela(AbstractDungeon.player, 1), 1));
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));

    }

 public void obtain() {
    AbstractPlayer player = AbstractDungeon.player;
    if (player.hasRelic(LotusBox.ID)) {
        int index = -1;
        for (int i = 0; i < player.relics.size(); i++) {
            if (player.relics.get(i) instanceof LotusBox) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            instantObtain(player, index, true);
        }

        flash();
    } else {
        super.obtain();
    }
}


    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + 1 + this.DESCRIPTIONS[1];
    }

    @Override
    public AbstractRelic makeCopy() {
        return (AbstractRelic)new XiangPiaoPiao();
    }

    public boolean canSpawn() {
        return AbstractDungeon.player.hasRelic("LotusBox");
    }

}
