package ninja.cards;

import ninja.actions.HolyLittleStormAction;
import ninja.actions.NinjutsuAction;
import ninja.Ninja;
import ninja.enums.CardColorEnum;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class HolyLittleStorm extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("HolyLittleStorm");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/HolyLittleStorm.png";
    public static final String ID = "HolyLittleStorm";

    public HolyLittleStorm() {
        super(ID, NAME, Ninja.getResourcePath(IMG_PATH), 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        this.tags.add(CardTags.NINJUTSU);
        this.baseDamage = 8;
        this.tags.add(CardTags.BLADE);
        this.tags.add(CardTags.HAND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower lexkela = p.getPower("LexKela");
        if (lexkela == null) {
            return;
        }
        int amount = lexkela.amount;
        if (p.hasRelic("MachineNinja")) {
            if (!p.hasPower("DimDeadTreePower")) {
                amount--;
            }
        }
        this.addToBot(new NinjutsuAction(p, new HolyLittleStormAction(p, this.damage, amount), amount, "HolyLittleStorm"));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
        }
    }

    public AbstractCard makeCopy() {
        return new HolyLittleStorm();
    }
}
