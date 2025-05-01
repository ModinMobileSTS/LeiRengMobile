package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.actions.OhFuckFlashAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.BufferPower;

public class OhFuckFlash extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("OhFuckFlash");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/OhFuckFlash.png";
    public static final String ID = "OhFuckFlash";

    public OhFuckFlash(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE,CardTarget.SELF);
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
        this.tags.add(CardTags.NINJUTSU);
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new ApplyPowerAction(p,p,new BufferPower(p,1),1));
        this.addToBot(new NinjutsuAction(p,new OhFuckFlashAction(), this.magicNumber , "OhFuckFlash"));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(-1);
        }
    }

    public AbstractCard makeCopy(){
        return new OhFuckFlash();
    }
}
