package ninja.cards;

import ninja.Ninja;
import ninja.actions.NinjutsuAction;
import ninja.actions.StoneStrongAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.ArtifactPower;

public class StoneStrong extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("StoneStrong");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/StoneStrong.png";
    private static final int COST = 1;
    private static final int UPGRADE_PLUS_MAGIC = 2;
    public static final String ID = "StoneStrong";
    private static final int NINJUTSU = 2;

    public StoneStrong(){
        super(ID, NAME, Ninja.getResourcePath( IMG_PATH), COST, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 6;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m){
        this.addToBot(new ApplyPowerAction(p,p,new ArtifactPower( p , 1),1));
        this.addToBot(new NinjutsuAction(p, new StoneStrongAction(p,magicNumber),1,"StoneStrong"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC);
        }
    }

    public AbstractCard makeCopy(){
        return new StoneStrong();
    }
}
