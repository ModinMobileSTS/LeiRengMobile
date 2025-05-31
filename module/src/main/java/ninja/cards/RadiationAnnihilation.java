package ninja.cards;

import ninja.actions.RadiationAnnihilationAction;
import ninja.actions.ScienceAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class RadiationAnnihilation extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("RadiationAnnihilation");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/RadiationAnnihilation.png";
    public static final String ID = "RadiationAnnihilation";

    public RadiationAnnihilation(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 5, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.SCIENCE);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        CardCrawlGame.sound.play(ID);
                this.addToBot(new RadiationAnnihilationAction(p,this.magicNumber));
        this.addToBot(new ScienceAction(p));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new RadiationAnnihilation();
    }
}
