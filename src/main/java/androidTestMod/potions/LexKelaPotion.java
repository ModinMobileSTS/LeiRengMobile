package androidTestMod.potions;

import androidTestMod.powers.LexKela;
import basemod.abstracts.CustomPotion;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GameDictionary;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class LexKelaPotion extends CustomPotion {
    public static final String POTION_ID = "LexKelaPotion";
    private static final PotionStrings potionStrings;

    public LexKelaPotion() {
        super(potionStrings.NAME, "LexKelaPotion", PotionRarity.COMMON, PotionSize.H, PotionColor.WEAK);
        this.labOutlineColor = Settings.SHADOW_COLOR;
        this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];
        this.isThrown = false;
    }

    public void initializeData() {
        this.potency = this.getPotency();
        this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
        this.tips.add(new PowerTip(TipHelper.capitalize(GameDictionary.INTANGIBLE.NAMES[0]), (String)GameDictionary.keywords.get(GameDictionary.INTANGIBLE.NAMES[0])));
    }

    public void use(AbstractCreature target) {
        AbstractCreature var2 = AbstractDungeon.player;
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            CardCrawlGame.sound.play("LexKelaPotion");
            this.addToBot(new ApplyPowerAction(var2, AbstractDungeon.player, new LexKela(var2, this.potency), this.potency));
        }

    }

    public int getPotency(int ascensionLevel) {
        return 3;
    }

    public AbstractPotion makeCopy() {
        return new LexKelaPotion();
    }

    static {
        potionStrings = CardCrawlGame.languagePack.getPotionString("LexKelaPotion");
    }
}
