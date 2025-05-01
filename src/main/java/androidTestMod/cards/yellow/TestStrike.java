package androidTestMod.cards.yellow;

import androidTestMod.AndroidTestMod;
import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class TestStrike extends CustomCard {
    public static final String ID = AndroidTestMod.makeId("TestStrike");
    public static final String IMG_PATH = AndroidTestMod.getResourcePath("cards/testStrike.png");
    private static final CardType TYPE = CardType.ATTACK;
    private static final String NAME;
    private static final String DESCRIPTION;
    private static final CardStrings cardStrings;
    private static final int COST = 1;

    public TestStrike() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, CardColorEnum.SILVER, CardRarity.BASIC, CardTarget.ENEMY);
        this.baseDamage = 6;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(3);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
