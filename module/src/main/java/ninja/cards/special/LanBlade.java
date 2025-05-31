package ninja.cards.special;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class LanBlade extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("LanBlade");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/LanBlade.png";
    public static final String ID = "LanBlade";

    public LanBlade(){
        super (ID, NAME, Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, CardType.ATTACK, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.ENEMY);
        this.exhaust = true;
        this.tags.add(CardTags.BLADE);
        this.baseDamage = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        CardCrawlGame.sound.play(ninja.cards.YiCut.ID);
                this.addToBot(new DamageAction(m, new DamageInfo(p,this.damage), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(2);
        }
    }

    public AbstractCard makeCopy(){
        return new LanBlade();
    }
}
