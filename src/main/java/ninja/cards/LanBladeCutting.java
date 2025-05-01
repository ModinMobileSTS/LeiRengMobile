package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.cards.special.LanBlade;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.LanBladePower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class LanBladeCutting extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("LanBladeCutting");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/LanBladeCutting.png";
    public static final String ID = "LanBladeCutting";

    public LanBladeCutting() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.BLADE);
        this.tags.add(CardTags.NINJUTSU);
        this.cardsToPreview = new LanBlade();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
                this.addToBot(new NinjutsuAction(p,new MakeTempCardInHandAction(new LanBlade(),this.magicNumber),1,""));
        this.addToBot(new ApplyPowerAction(p,p,new LanBladePower( p , this.magicNumber),this.magicNumber));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy() {
        return new LanBladeCutting();
    }
}
